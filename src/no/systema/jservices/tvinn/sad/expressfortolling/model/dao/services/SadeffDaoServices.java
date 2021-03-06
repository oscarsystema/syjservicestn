package no.systema.jservices.tvinn.sad.expressfortolling.model.dao.services;
import java.util.*;


/**
 * 
 * @author oscardelatorre
 * @date Aug 2020
 * 
 */
public interface SadeffDaoServices extends IDaoServices { 
	public List find(Object dao,StringBuffer errorStackTrace);
	public int updateStatus(Object daoObj, StringBuffer errorStackTrace);
	public int updateManifestStatus(Object daoObj, StringBuffer errorStackTrace);
}
