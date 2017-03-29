package org.loversAPP.service;

import org.loversAPP.model.Version;

/**
 * Created by Administrator on 2017/3/29.
 */
public interface VsersionService {

    public Version getVersionByid();

    public int   updateVersion(Version version);
}
