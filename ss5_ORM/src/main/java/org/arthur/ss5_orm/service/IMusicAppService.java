package org.arthur.ss5_orm.service;

import org.arthur.ss5_orm.model.MusicApp;

import java.util.List;

public interface IMusicAppService {
    List<MusicApp> getList();
    List<MusicApp> search(String input);
    Boolean addNew(MusicApp musicApp);
    Boolean update(MusicApp musicApp);
    Boolean delete(MusicApp musicApp);
}
