import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactItemTest {

    @Test
    public void creationFailsWithAllBlankValues()
    {
        ContactItem contact = new ContactItem("", "", "", "");
        assertEquals(null, contact.getFirstName());

    }

    @Test
    public void creationSucceedsWithBlankEmail()
    {
        ContactItem contact = new ContactItem("aaron", "haro", "2226", "");
        assertEquals("aaron", contact.getFirstName());
    }


    @Test
    public void creationSucceedsWithBlankFirstName()
    {
        ContactItem contact = new ContactItem("", "haro", "2226", "");
        assertEquals("", contact.getFirstName());
    }

    @Test
    public void creationSucceedsWithBlankLastName()
    {
        ContactItem contact = new ContactItem("", "", "2226", "");
        assertEquals("", contact.getFirstName());
    }

    @Test
    public void creationSucceedsWithBlankPhone()
    {
        ContactItem contact = new ContactItem("", "dsadasf", "", "");
        assertEquals("", contact.getFirstName());
    }

    @Test
    public void creationSucceedsWithNonBlankValues()
    {
        ContactItem contact = new ContactItem("test", "dsadasf", "214124", "5125125");
        assertEquals("test", contact.getFirstName());
    }


    @Test
    public void editingFailsWithAllBlankValues()
    {
        ContactItem contact = new ContactItem("test", "dsadasf", "214124", "5125125");
        ContactList contacts = new ContactList();
        contacts.add(contact);
        contacts.editContact(0,"", "", "", "");
        assertEquals("test", contact.getFirstName());
        // still needs work

    }


    @Test
    public void editingSucceedsWithBlankEmail()
    {
        ContactItem contact = new ContactItem("test", "dsadasf", "214124", "5125125");
        ContactList contacts = new ContactList();
        contacts.add(contact);
        contacts.editContact(0,"name", "asfasf", "fafasfa", "");
        assertEquals("", contact.getEmail());
        contacts.clear();

    }


    @Test
    public void editingSucceedsWithBlankFirstName()
    {
        ContactItem contact = new ContactItem("test", "dsadasf", "214124", "5125125");
        ContactList contacts = new ContactList();
        contacts.add(contact);
        contacts.editContact(0,"", "asfasf", "fafasfa", "");
        assertEquals("", contact.getFirstName());
        contacts.clear();
    }

    @Test
    public void  editingSucceedsWithBlankLastName()
    {
        ContactItem contact = new ContactItem("test", "dsadasf", "214124", "5125125");
        ContactList contacts = new ContactList();
        contacts.add(contact);
        contacts.editContact(0,"", "", "fafasfa", "");
        assertEquals("", contact.getLastName());
        contacts.clear();
    }


    @Test
    public void editingSucceedsWithBlankPhone()
    {
        ContactItem contact = new ContactItem("test", "dsadasf", "214124", "5125125");
        ContactList contacts = new ContactList();
        contacts.add(contact);
        contacts.editContact(0,"", "adsdas", "", "");
        assertEquals("", contact.getPhoneNumber());
        contacts.clear();
    }
    @Test
    public void editingSucceedsWithNonBlankValues()
    {
        ContactItem contact = new ContactItem("test", "dsadasf", "214124", "5125125");
        ContactList contacts = new ContactList();
        contacts.add(contact);
        contacts.editContact(0,"name ", "adsdas", "21412", "51252@gov.com");
        assertEquals("21412", contact.getPhoneNumber());
        contacts.clear();
    }


}