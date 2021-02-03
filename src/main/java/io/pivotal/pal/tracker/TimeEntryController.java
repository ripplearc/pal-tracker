package io.pivotal.pal.tracker;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TimeEntryController {
    private final TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }


    public ResponseEntity<TimeEntry> create(TimeEntry timeEntryToCreate) {
        TimeEntry entry = timeEntryRepository.create(timeEntryToCreate);
        return ResponseEntity.created(null).body(entry);
    }

    public ResponseEntity<TimeEntry> read(long timeEntryId) {
        TimeEntry entry = timeEntryRepository.find(timeEntryId);
        if (entry != null)
            return ResponseEntity.ok(entry);
        else
            return ResponseEntity.notFound().build();
    }

    public ResponseEntity<List<TimeEntry>> list() {
        List<TimeEntry> entries = timeEntryRepository.list();
        return ResponseEntity.ok(entries);
    }

    public ResponseEntity<TimeEntry> update(long timeEntryId, TimeEntry timeEntryToUpdate) {
        TimeEntry entry = timeEntryRepository.update(timeEntryId, timeEntryToUpdate);
        if (entry != null)
            return ResponseEntity.ok(entry);
        else
            return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Void> delete(long timeEntryId) {
        timeEntryRepository.delete(timeEntryId);
        return ResponseEntity.noContent().build();
    }
}
