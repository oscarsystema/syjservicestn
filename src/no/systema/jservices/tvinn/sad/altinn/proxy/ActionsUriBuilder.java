package no.systema.jservices.tvinn.sad.altinn.proxy;

import java.io.Serializable;
import java.net.URI;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Creates URI on https://www.altinn.no/api/Help
 * 
 * @author Fredrik Möller
 * @date 2018
 */
public class ActionsUriBuilder {

	/**
	 * Gets the user profile of the currently authenticated user.
	 * 
	 * @param host
	 * @param orgnr
	 * @return URI, ex. GET {orgno}/profile
	 */
	public static URI profile(String host, int orgnr) {

		UriComponents uriComponents = UriComponentsBuilder.newInstance()
				.scheme("https")
				.host(host)
				.path("/api/{who}/profile")
				.build()
				.expand(orgnr)
				.encode();

		return uriComponents.toUri();

	}
	
	/**
	 * Gets the list of available API-services in Altinn.
	 * 
	 * @param host
	 * @return URI, ex. GET metadata
	 */
	public static URI metadata(String host) {

		UriComponents uriComponents = UriComponentsBuilder.newInstance()
				.scheme("https")
				.host(host)
				.path("/api/metadata")
				.build()
				.encode();

		return uriComponents.toUri();

	}	
	
	/**
	 * Gets all messages for the given 'who', here orgnr. These can optionally be retrieved in the language specified.
	 * 
	 * @param host
	 * @param orgnr
	 * @return URI, ex. GET {who}/Messages?language={language}
	 */
	public static URI messages(String host, int orgnr) {

		UriComponents uriComponents = UriComponentsBuilder.newInstance()
				.scheme("https")
				.host(host)
				.path("/api/{who}/messages")
				.build()
				.expand(orgnr)
				.encode();

		return uriComponents.toUri();

	}

	/**
	 * Gets all messages for the given 'who', here orgnr. These can optionally be retrieved in the language specified.
	 * 
	 * Filtered on serviceownercode, e.g. SKD (=Skatteetaten)
	 * 
	 * @param host
	 * @param orgnr
	 * @param serviceOwneer
	 * @return URI, ex. GET {who}/Messages?language={language}
	 */
	public static URI messages(String host, int orgnr, ServiceOwnerCode serviceOwneer) {

		UriComponents uriComponents = UriComponentsBuilder.newInstance()
				.scheme("https")
				.host(host)
				.path("/api/{who}/messages/$filter=ServiceOwnerCode eq \'"+serviceOwneer+"\'")
				.build()
				.expand(orgnr)
				.encode();

		return uriComponents.toUri();

	}
	
	/**
	 * Contains all actions related to the authorization roles
	 * 
	 * @param host
	 * @param orgnr
	 * @return URI, ex. GET {who}/authorization/roles?language={language}
	 */
	public static URI roles(String host, int orgnr) {

		UriComponents uriComponents = UriComponentsBuilder.newInstance()
				.scheme("https")
				.host(host)
				.path("/api/{who}/authorization/roles")
				.build()
				.expand(orgnr)
				.encode();

		return uriComponents.toUri();

	}	
	
}
