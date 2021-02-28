package sessions;

import dto.CartItemDTO;
import dto.CustomerDTO;
import dto.CustomerOrderDTO;
import entities.CustomerOrder;
import entities.Inventory;
import entities.Product;
import interfaces.CustomerOrderFacadeLocal;
import interfaces.ProductFacadeLocal;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.CreditCard;
import session.CustomerOrderManagementRemote;
import utilities.HashHelper;

/**
 *
 * @author 101042618
 */
@Stateless
public class CustomerOrderManagement implements CustomerOrderManagementRemote {

    @EJB
    private CustomerOrderFacadeLocal customerOrderFacade;

    @EJB
    private ProductFacadeLocal productFacade;

    @EJB
    private InventoryManagement inventoryManagement;
    
    @EJB
    private CustomerOrderProductManagement customerOrderProductManagement;

    @EJB
    private CustomerNotificationManagement customerNotificationManagement;

    private CustomerOrder customerOrderDTO2Entity(CustomerOrderDTO customerOrderDTO)
            throws NoSuchAlgorithmException {
        if (customerOrderDTO == null) {
            return null;
        }

        CustomerDTO customer = customerOrderDTO.getCustomer();

        String fname = customer.getFname();
        String lname = customer.getLname();
        String email = customer.getEmail();
        String mobile = customer.getMobile();
        String address = customer.getAddress();
        String suburb = customer.getSuburb();
        String postCode = customer.getPostCode();
        String state = customer.getState();
        CreditCard creditCard = customer.getCreditCard();
        String creditCardNo = HashHelper.toSHA256(creditCard.getCreditcardNo());
        Integer customerMemberId = customer.getCustomerMemberId();

        return new CustomerOrder(fname, lname, email, mobile, address, suburb, postCode, state, creditCardNo, customerMemberId);
    }

    @Override
    public String addOrder(CustomerOrderDTO customerOrderDTO) {
        if (customerOrderDTO == null) {
            return "CustomerOrderDTO object is null";
        }

        try {
            // convert to entity
            CustomerOrder customerOrder = this.customerOrderDTO2Entity(customerOrderDTO);
            customerOrderFacade.addRecord(customerOrder);

            for (CartItemDTO cartItemDto : customerOrderDTO.getProducts()) {
                Product product = productFacade.find(cartItemDto.getProduct().getId());
                customerOrderProductManagement.addOrderProduct(customerOrder, product, cartItemDto.getQuantityAdded());

                // update the stock quantity
                Inventory inventory = product.getInventory();
                int currentStockQuantity = inventory.getStockquantity();
                inventory.setStockquantity(currentStockQuantity - cartItemDto.getQuantityAdded());
                inventoryManagement.updateInventoryDetails(inventory);
            }

            customerNotificationManagement.sendEmail(customerOrder.getFirstname(), customerOrder.getEmail(), CustomerNotificationManagement.ServiceType.PurchaseProducts);

            return "success";
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CustomerOrderManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "failure";
    }
}
