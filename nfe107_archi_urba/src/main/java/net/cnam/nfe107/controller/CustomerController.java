package net.cnam.nfe107.controller;

/*
 * @created 29/10/2020/10/2020 - 11:23
 * @project nfe107_archi_urba
 * @author Ohtnaoh - AD
 */

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("customer")
public class CustomerController {


    /*
    @Autowired
    CustomerService customerService;

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<CustomerDTOOut> create(@RequestBody CustomerDTOIn customerDTOIn){
        ECustomerToCreate eCustomerToCreate = new ECustomerToCreate(customerDTOIn);
        ECustomer cCreated = customerService.create(eCustomerToCreate);
        return new ResponseEntity<CustomerDTOOut>(new CustomerDTOOut(cCreated), HttpStatus.CREATED);
    }


    @GetMapping("/getAll")
    @ResponseBody
    public List<CustomerDTOOut> getAll(){
        List<ECustomer> cFound = customerService.getAll();
        List<CustomerDTOOut> dtoOutCustomers = new ArrayList<>();
        for (ECustomer eC: cFound) {
            dtoOutCustomers.add(new CustomerDTOOut(eC));
        }
        return dtoOutCustomers;
    }

    @GetMapping("/getById/{id}")
    @ResponseBody
    public ResponseEntity<CustomerDTOOut> getById(@PathVariable("id") Long id){

        CustomerDTOOut dtoOutCustomer = new CustomerDTOOut(getECustomerById(id));
        return new ResponseEntity<CustomerDTOOut>(dtoOutCustomer, HttpStatus.OK);
    }

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<CustomerDTOOut> update(@RequestBody CustomerDTOInWithId customerDTOIn){
        ECustomer toUpdate = new ECustomer(customerDTOIn);
        ECustomer eCustomerUpdate = customerService.update(toUpdate);
        return new ResponseEntity<CustomerDTOOut>(new CustomerDTOOut(eCustomerUpdate), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id){

        customerService.delete(getECustomerById(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private ECustomer getECustomerById(Long id){
        ECustomer cFound = customerService.getById(id);
        return cFound;
    }
    */


}
