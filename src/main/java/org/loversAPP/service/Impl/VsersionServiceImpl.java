package org.loversAPP.service.Impl;

import org.loversAPP.dao.VersionMapper;
import org.loversAPP.model.Version;
import org.loversAPP.service.VsersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/3/29.
 */
@Service
public class VsersionServiceImpl implements VsersionService {
    @Autowired
    private VersionMapper versionMapper;
    public Version getVersionByid() {
        return versionMapper.selectByPrimaryKey(1);
    }

    public int updateVersion(Version version) {
        version.setId(1);
        return versionMapper.updateByPrimaryKeySelective(version);
    }
}
