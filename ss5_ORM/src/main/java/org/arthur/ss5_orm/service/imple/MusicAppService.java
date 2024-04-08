package org.arthur.ss5_orm.service.imple;

import org.arthur.ss5_orm.model.MusicApp;
import org.arthur.ss5_orm.repository.IMusicAppRepo;
import org.arthur.ss5_orm.service.IMusicAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicAppService implements IMusicAppService {
    @Autowired
    IMusicAppRepo musicAppRepo;

    @Override
    public List<MusicApp> getList() {
        return musicAppRepo.getList();
    }

    @Override
    public List<MusicApp> search(String input) {
        return musicAppRepo.search(input);
    }

    @Override
    public Boolean addNew(MusicApp musicApp) {
        return musicAppRepo.addNew(musicApp);
    }

    @Override
    public Boolean update(MusicApp musicApp) {
        return musicAppRepo.update(musicApp);
    }

    @Override
    public Boolean delete(MusicApp musicApp) {
        musicApp.setActive(!musicApp.isActive());
        return musicAppRepo.delete(musicApp);
    }

}
