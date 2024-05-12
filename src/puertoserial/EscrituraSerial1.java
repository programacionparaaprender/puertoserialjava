package puertoserial;

import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;

 //descargar software VSP para virtualizar puertos COM
public class EscrituraSerial1 {
	public static void main(String[] args) {
		Enumeration puertos; //busca todos los puertos y los guarda en el objeto puertos
		OutputStream ops; 
		puertos=CommPortIdentifier.getPortIdentifiers(); //ojo tiene que tener la -s- al ultimo porque hay otro metodo sin -s-
		CommPortIdentifier portId; // identifica los puertos com
		SerialPort serialport; // esta clase abre puertos
		while (puertos.hasMoreElements()) { //para recorrer el numero de los puertos, y especificar con cual quiero trabajar 
			//hasmorelements mientras tenga mas eleementos
			portId = (CommPortIdentifier) puertos.nextElement(); //next elemento recorre uno por uno
			System.out.println(portId.getName()); //puertos disponbibles
			if (portId.getName().equalsIgnoreCase("COM7")) {
				try {
					serialport= (SerialPort)portId.open("EscrituraSerial1", 500);//tiempo en ms
					ops=serialport.getOutputStream();
					ops.write (" UPS".getBytes()); //get bytes transforma el string a bytes
					ops.close();
					serialport.close();
				} catch (Exception e) {
					// TODO: handle exception
				}	
			}
		}
	}
}
