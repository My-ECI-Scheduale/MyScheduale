package edu.eci.arsw.myecischedule.service;

import edu.eci.arsw.myecischedule.model.ModificationLog;
import edu.eci.arsw.myecischedule.model.Packet;
import edu.eci.arsw.myecischedule.repository.ModificationLogRepository;

public class ModificationLogService extends Thread {

    private Packet modificationLog;
    private ModificationLogRepository modificationLogRepository;

    public ModificationLog create() {
        ModificationLog temp = new ModificationLog(modificationLog.getAction(), modificationLog.getIdcolumn(),
                modificationLog.getUsername(), modificationLog.getIdtask(), modificationLog.getDescription(),
                modificationLog.isIpublic(), modificationLog.getIdcustomer(), modificationLog.getKanban());
        return modificationLogRepository.save(temp);
    }

    public Packet getModificationLog() {
        return modificationLog;
    }

    public void setModificationLog(Packet modificationLog) {
        this.modificationLog = modificationLog;
    }

    public ModificationLogRepository getModificationLogRepository() {
        return modificationLogRepository;
    }

    public void setModificationLogRepository(ModificationLogRepository modificationLogRepository) {
        this.modificationLogRepository = modificationLogRepository;
    }

    @Override
    public void run() {
        create();
    }
}
