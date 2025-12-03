package dao;

import model.Contact;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class ContactDAO {

    private static final List<Contact> contacts = new CopyOnWriteArrayList<>();

    public List<Contact> getAll() {
        return contacts;
    }

    public void add(Contact c) {
        if (c.getId() == null || c.getId().isEmpty()) {
            c.setId(UUID.randomUUID().toString());
        }
        contacts.add(c);
    }

    public Contact getById(String id) {
        return contacts.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }

    public boolean update(Contact updated) {
        Contact existing = getById(updated.getId());
        if (existing == null) return false;

        existing.setName(updated.getName());
        existing.setPhone(updated.getPhone());
        existing.setEmail(updated.getEmail());
        existing.setAddress(updated.getAddress());

        return true;
    }

    public boolean delete(String id) {
        return contacts.removeIf(c -> c.getId().equals(id));
    }
}
