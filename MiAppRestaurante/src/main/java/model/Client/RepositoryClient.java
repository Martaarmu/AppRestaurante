package model.Client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import model.Order.Order;

@XmlRootElement(name = "repository")
@XmlAccessorType(XmlAccessType.FIELD)
public class RepositoryClient implements Serializable {

	private static RepositoryClient instance;
	@XmlElement(name = "employee")
	static List<Client> clients;

	private RepositoryClient() {

	}

	public static RepositoryClient getInstance() {
		if (instance == null) {
			instance = new RepositoryClient();
			clients = new ArrayList<Client>();
		}
		return instance;
	}
	/**
	 * Añade clientes
	 * @param c
	 */

	public void addClient(Client c) {
		clients.add(c);
	}

	public void Rellenar() {
		clients.add(new Client("111B", "Marta", 23, "Calle Falsa, 30"));
	}

	/***
	 * Muestra todos los clientes.
	 */
	public void getAllClients() {
		System.out.println(clients);
	}

	/***
	 * Buscamos el cliente por el nombre.
	 * 
	 * @param name
	 * @return devuelve la lista de clientes que contengan ese nombre
	 */
	public List<Client> searchClientName(String name) {
		List<Client> listClients = new ArrayList<Client>();
		for (Client c : clients) {
			if (c != null && c.getName().equals(name)) {
				System.out.println(c);
				listClients.add(c);
			}
		}
		return listClients;
	}
	/**
	 * Borra clientes mediante dni
	 * @param dni
	 */
	public void deleteClient(String dni) {

		Iterator<Client> miiterador = clients.iterator();
		while (miiterador.hasNext()) {
			Client c = miiterador.next();
			if (c.getDni().equals(dni)) {
				miiterador.remove();
			}
		}
	}

	/***
	 * Buscamos el cliente por el DNI
	 * 
	 * @param dni
	 * @return true (si el cliente existe) o false (si el cliente no existe).
	 */

	public boolean existClient(String dni) {

		boolean result = false;

		for (Client c : clients) {
			if (c != null && c.getDni().equals(dni)) {
				result = true;
			}
		}
		return result;
	}
	/**
	 * Busca clientes por el dni
	 * @param dni
	 * @return cliente
	 */
	public Client searchClientDni(String dni) {

		Client c1 = new Client();
		for (Client c : clients) {
			if (c != null && c.getDni().equals(dni)) {
				c1 = c;
			}
		}
		System.out.println(c1);
		return c1;
	}
	/**
	 * Guarda datos en fichero XML
	 * @param url
	 */
	public void saveClient(String url) {
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(RepositoryClient.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(getInstance(), new File(url));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Carga datos de los ficheros XML
	 * @param url
	 */
	public void loadClient(String url) {
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(RepositoryClient.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			RepositoryClient newR = (RepositoryClient) jaxbUnmarshaller.unmarshal(new File(url));
			clients = newR.clients;
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public String toString() {
		return "CLIENTES\n" + clients;
	}

}
