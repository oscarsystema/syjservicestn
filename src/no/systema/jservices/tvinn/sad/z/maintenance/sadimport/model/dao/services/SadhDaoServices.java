package no.systema.jservices.tvinn.sad.z.maintenance.sadimport.model.dao.services;
import java.util.*;

import no.systema.jservices.tvinn.sad.z.maintenance.felles.model.dao.entities.KodtlbDao;
import no.systema.jservices.tvinn.sad.z.maintenance.sad.model.dao.services.IDaoServices;

/**
 * 
 * @author oscardelatorre
 * @date Jun 17, 2016
 * 
 */
public interface SadhDaoServices extends IDaoServices { 
	public List getListByAvd(String avd, StringBuffer errorStackTrace);
	public List getListByAvdOpd(String avd, String opd, StringBuffer errorStackTrace);
	public List findForUpdate(String avd, String opd, StringBuffer errorStackTrace);
}
