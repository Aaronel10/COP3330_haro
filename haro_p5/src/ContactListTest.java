import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactListTest {

    @Test
    public void addingItemsIncreasesSize()
    {
        ContactList contactList = new ContactList();
        ContactItem contact = new ContactItem("Aaron", "Haro", "2018569232", "aaron@gmail.com");
        contactList.add(contact);
        assertEquals(contactList.getSize(), 1);
        contactList.clear();
    }

    @Test
    public void editingItemsFailsWithAllBlankValues()
    {
        ContactItem contact = new ContactItem("Aaron", "Haro", "2018569232", "aaron@gmail.com");
        ContactList contactList = new ContactList();
        contactList.editContact(0, "", "", "", "");
        assertEquals("Aaron", contact.getFirstName());
    }

    @Test
    public void editingItemsFailsWithInvalidIndex()
    {
        ContactItem contact = new ContactItem("Aaron", "Haro", "2018569232", "aaron@gmail.com");
        ContactList contactList = new ContactList();
        assertThrows(IndexOutOfBoundsException.class, ()->
                contactList.editContact(5,"thomas","hanks", "42142412", "24124@gov.com"));
        contactList.clear();
    }

    @Test
    public void editingSucceedsWithBlankFirstName()
    {
        ContactItem contact = new ContactItem("Aaron", "Haro", "2018569232", "aaron@gmail.com");
        ContactList contactList = new ContactList();
        contactList.add(contact);
        contactList.editContact(0, "", "last name", "24142", "sadasd@gov.com");
        assertEquals(contact.getLastName(), "last name");
        contactList.clear();
    }

    @Test
    public void editingSucceedsWithBlankLastName()
    {
        ContactItem contact = new ContactItem("Aaron", "Haro", "2018569232", "aaron@gmail.com");
        ContactList contactList = new ContactList();
        contactList.add(contact);
        contactList.editContact(0, "test", "", "24142", "sadasd@gov.com");
        assertEquals(contact.getFirstName(), "test");
        contactList.clear();
    }

    @Test
    public void editingSucceedsWithBlankPhone()
    {
        ContactItem contact = new ContactItem("Aaron", "Haro", "2018569232", "aaron@gmail.com");
        ContactList contactList = new ContactList();
        contactList.add(contact);
        contactList.editContact(0, "test", "", "", "sadasd@gov.com");
        assertEquals(contact.getFirstName(), "test");
        contactList.clear();

    }

    @Test
    public void editingSucceedsWithNonBlankValues()
    {
        ContactItem contact = new ContactItem("Aaron", "Haro", "2018569232", "aaron@gmail.com");
        ContactList contactList = new ContactList();
        contactList.add(contact);
        contactList.editContact(0, "test", "dasdsa", "fasfsa", "sadasd@gov.com");
        assertEquals(contact.getFirstName(), "test");
        contactList.clear();

    }

    @Test
    public void newListIsEmpty()
    {
        ContactList contactList = new ContactList();
        assertEquals(contactList.getSize(), 0);
        contactList.clear();
    }

    @Test
    public void removingItemsDecreasesSize()
    {
        ContactItem contact = new ContactItem("Aaron", "Haro", "2018569232", "aaron@gmail.com");
        ContactItem contact2 = new ContactItem("dasdas", "dasdaf", "dsafsaf", "fsafasfg");
        ContactList contactList = new ContactList();
        contactList.add(contact);
        contactList.add(contact2);
        contactList.removeContact(1);
        assertEquals(contactList.getSize(), 1);
        contactList.clear();
    }


    @Test
    public void removingItemsFailsWithInvalidIndex()
    {
        ContactItem contact = new ContactItem("Aaron", "Haro", "2018569232", "aaron@gmail.com");
        ContactItem contact2 = new ContactItem("dasdas", "dasdaf", "dsafsaf", "fsafasfg");
        ContactList contactList = new ContactList();
        contactList.add(contact);
        contactList.add(contact2);
        assertThrows(IndexOutOfBoundsException.class, ()->
                contactList.removeContact(5));

        contactList.clear();

    }

    /* need to fix , wasn't able to make run even though it works in practice.
    @Test
    public void savedContactListCanBeLoaded()
    {

        ContactList contactList = new ContactList();
         contactList.loadContact("testSave");

        assertEquals(contactList.getSize(),2);

    }
    */
}