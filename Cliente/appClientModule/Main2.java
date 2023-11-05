import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.json.simple.*;

public class Main2 {
	public static void main(String[] args) {

	    SSLContext sslContext;
		try {
			sslContext = SSLContext.getInstance("TLS");
			sslContext.init(null, new TrustManager[]{new GestorCerts()}, null);
		    Client client = ClientBuilder.newBuilder().sslContext(sslContext).build();
			WebTarget target = client.target("https://opendata.gijon.es/descargar.php?id=941&tipo=JSON");
			String result = target.request().get().readEntity(String.class);
			JSONObject obj = (JSONObject) JSONValue.parse(result);
			JSONObject datos = (JSONObject) JSONValue.parse(obj.get("datos").toString());
			JSONArray dato = (JSONArray) JSONValue.parse(datos.get("dato").toString());
			System.out.println("----------- Dato 0 ----------------");
			System.out.println(dato.get(0).toString());
			System.out.println("----------- Dato 1 Por separado ----------------");
			JSONObject dato1 = (JSONObject) JSONValue.parse(dato.get(1).toString());
			System.out.println("id_equipo: " + dato1.get("id_equipo"));
			System.out.println("id_tipo_equipo: "+dato1.get("id_tipo_equipo"));
			System.out.println("ubicacion: "+dato1.get("ubicacion"));
			System.out.println("fecha_instalacion: "+dato1.get("fecha_instalacion"));
			System.out.println("fecha_consulta: "+dato1.get("fecha_consulta"));
		} catch (NoSuchAlgorithmException | KeyManagementException e1) {
			e1.printStackTrace();
		}

	}

	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
	public Main2() {
		super();
	}

}