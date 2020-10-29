package net.cnam.nfe107.controller.dto;

/*
 * @created 29/10/2020/10/2020 - 19:22
 * @project nfe107_archi_urba
 * @author Ohtnaoh - AD
 */

public class CustomerDTOInWithId {

        private Long id;
        private String firstname;
        private String lastname;
        private String email;
        private String phoneNumber;
        private String address;

        public CustomerDTOInWithId(Long id, String firstname, String lastname, String email, String phoneNumber, String address) {
            this.id = id;
            this.firstname = firstname;
            this.lastname = lastname;
            this.email = email;
            this.phoneNumber = phoneNumber;
            this.address = address;
        }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
}
