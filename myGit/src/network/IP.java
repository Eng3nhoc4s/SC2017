package network;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IP {

	private String ipAdress;
	private int port;
	
	/**
	 * Stores an ip address
	 * @param address Ip and Port in format ip:port
	 */
	public IP (String address){
		String [] ipAndPort = address.split(":");
		
		ipAdress = ipAndPort[0];
		port = Integer.parseInt(ipAndPort[1]);
	}

	/**
	 * Returns the ip adress
	 * @return String with ip address
	 */
	public String getIpAdress() {
		return ipAdress;
	}

	/**
	 * Returns the port
	 * @return Short with the port value
	 */
	public int getPort() {
		return port;
	}
	
	/**
	 * Validates an IP address
	 * @return True if IP address is valid, else False
	 */
	public boolean isValid(){
		
		String IPADDRESS_PATTERN =
				"^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
				"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
				"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
				"([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
		
		Pattern pattern = Pattern.compile(IPADDRESS_PATTERN);
	    Matcher matcher = pattern.matcher(ipAdress);
				
		return (matcher.matches()) && (port > 0 && port <= 65535);
	}
	
}
