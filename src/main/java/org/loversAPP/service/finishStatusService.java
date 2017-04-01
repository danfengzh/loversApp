package org.loversAPP.service;

import org.loversAPP.model.FinishStatus;

/**
 * Created by Administrator on 2017/3/13.
 */
public interface finishStatusService {
  public Integer finishStatus(Integer userID);
  public int setFinishStatusByUID(Integer userID, Integer status);
  public FinishStatus getFinishStatusByUID(Integer userID);
}
