package no.systema.jservices.tvinn.sad.z.maintenance.nctsexport.controller.rules;

import java.util.ArrayList;
import java.util.List;

import no.systema.jservices.jsonwriter.JsonResponseWriter;
import no.systema.jservices.tvinn.sad.z.maintenance.nctsexport.model.dao.entities.TrughDao;
import no.systema.jservices.tvinn.sad.z.maintenance.nctsexport.model.dao.services.TrughDaoServices;
/**
 * 
 * @author Fredrik Möller
 * @date Okt 2, 2016
 */
public class TR030R_U {
	private JsonResponseWriter jsonWriter = new JsonResponseWriter();
	private TrughDaoServices trughDaoServices = null;
	
	private StringBuffer errors = null;
	private StringBuffer dbErrors = null;

	public TR030R_U(TrughDaoServices trughDaoServices, StringBuffer sb, StringBuffer dbErrorStackTrace) {
		this.trughDaoServices = trughDaoServices;
		this.errors= sb;
		this.dbErrors = dbErrorStackTrace;
		
	}


	/**
	 * Validate null values and exist controls i db.
	 * 
	 * @param dao
	 * @param user
	 * @param mode
	 * @return
	 */
	public boolean isValidInput(TrughDao dao, String user, String mode) {
		if ((user != null && !"".equals(user)) && (mode != null && !"".equals(mode))) {
			// check dao
			if ((dao.getTggnr() != null && !"".equals(dao.getTggnr()))
					&& (dao.getTgtina() != null && !"".equals(dao.getTgtina()))
					&& (dao.getTgnaa() != null && !"".equals(dao.getTgnaa()))
					&& (dao.getTgpna() != null && !"".equals(dao.getTgpna()))
					&& (dao.getTgpsa() != null && !"".equals(dao.getTgpsa()))
					&& (dao.getTglka() != null && !"".equals(dao.getTglka()))
					&& (dao.getTggty() != null && !"".equals(dao.getTggty()))
					&& (dao.getTgtsd() != null && !"".equals(dao.getTgtsd()))
					&& (dao.getTgakny() != null && !"".equals(dao.getTgakny()))
					&& (dao.getTgakgm() != null && !"".equals(dao.getTgakgm()))
					&& (dao.getTggbl() != null && !"".equals(dao.getTggbl()))
					&& (dao.getTggvk() != null && !"".equals(dao.getTggvk())) ) {
				// Check duplicate
				if ("A".equals(mode) && existInTrugh(user, dao.getTggnr())) {
					return false;
				}

				
			} else {
				return false;
			}
		} else {
			return false;
		}
		
		return true;
	}

	public boolean isValidInputForDelete(TrughDao dao, String user, String mode){
		boolean retval = true;
		if( (user!=null && !"".equals(user)) && (mode!=null && !"".equals(mode)) ){
			//check dao
			if( (dao.getTggnr()!=null && !"".equals(dao.getTggnr())) ){
				//OK
			}else{
				retval = false;
			}
		}else{
			retval = false;
		}
		
		return retval;
	}
	
	public void updateNumericFieldsIfNull(TrughDao dao){
		String ZERO = "0";
		if(dao.getTggty()==null || "".equals(dao.getTggty())){
			dao.setTggty(ZERO);
		}
		if(dao.getTggbl()==null || "".equals(dao.getTggbl())){
			dao.setTggbl(ZERO);
		}
		if(dao.getTggblb()==null || "".equals(dao.getTggblb())){
			dao.setTggblb(ZERO);
		}
		if(dao.getTgkna()==null || "".equals(dao.getTgkna())){
			dao.setTgkna(ZERO);
		}
		if(dao.getTgdt()==null || "".equals(dao.getTgdt())){
			dao.setTgdt(ZERO);
		}
		if(dao.getTgdtr()==null || "".equals(dao.getTgdtr())){
			dao.setTgdtr(ZERO);
		}
		if(dao.getTgprm()==null || "".equals(dao.getTgprm())){
			dao.setTgprm(ZERO);
		}
	}


	private boolean existInTrugh(String userName, String tggnr) {
		boolean exist = false;
		List<TrughDao> list = new ArrayList<TrughDao>();
		list = this.trughDaoServices.findById(tggnr, dbErrors);
		// check if there is already such a code. If it does, stop the update
		if (list != null && list.size() == 0) {
			exist = false;
		} else {
			errors.append(jsonWriter.setJsonSimpleErrorResult(userName, "ERROR on ADD: Code exists already", "error",
					dbErrors));
			exist = true;

		}
		return exist;
	}



}