/**
* BluePay Java Sample code.
*
* This code sample runs a $15.00 Credit Card Sale transaction
* against a customer using test payment information.
* Optional transaction data is also sent.
* If using TEST mode, odd dollar amounts will return
* an approval and even dollar amounts will return a decline.
*/

package BluePayPayment.Transactions_BP10Emu;
import BluePayPayment.BluePayPayment_BP10Emu;

public class Customer_Defined_Data
{
  public static void main(String[] args)
  {

String ACCOUNT_ID = "MERCHANT'S ACCOUNT ID HERE";
String SECRET_KEY = "MERCHANT'S SECRET KEY HERE";
String MODE = "TEST";

// Merchant's Account ID
// Merchant's Secret Key
// Transaction Mode: TEST (can also be LIVE)
BluePayPayment_BP10Emu payment = new BluePayPayment_BP10Emu(
  ACCOUNT_ID,
  SECRET_KEY,
  MODE);

    // Card Number: 4111111111111111
    // Card Expire: 12/15
    // Card CVV2: 123
    payment.setCCInformation(
              "4111111111111111",
              "1215",
              "123");

    // First Name: Bob
    // Last Name: Tester
    // Address1: 123 Test St.
    // Address2: Apt #500
    // City: Testville
    // State: IL
    // Zip: 54321
    // Country: USA
    payment.setCustomerInformation(
              "Bob",
              "Tester",
              "123 Test St.",
              "Apt #500",
              "Testville",
              "IL",
              "54321",
              "USA");

    // Phone #: 123-123-1234
    payment.setPhone("1231231234");

    // Email Address: test@bluepay.com
    payment.setEmail("test@bluepay.com");

    // Custom ID1: 12345
    payment.setCustomID1("12345");

    // Custom ID2: 09866
    payment.setCustomID2("09866");

    // Invoice ID: 50000
    payment.setInvoiceID("500000");

    // Order ID: 10023145
    payment.setOrderID("10023145");

    // Tip Amount: $6.00
    payment.setAmountTip("6.00");

    // Tax Amount: $3.50
    payment.setAmountTax("3.50");

    // Food Amount: $3.11
    payment.setAmountFood("3.11");

    // Miscellaneous Amount: $5.00
    payment.setAmountMisc("5.00");

    // Sale Amount: $15.00
    payment.sale("15.00");
    try
    {
      payment.process();
    }
    catch (Exception ex)
    {
      System.out.println("Exception: " + ex.toString());
      System.exit(1);
    }
    if(payment.isError())
    {
      System.out.println("Error: " + payment.getMessage());
    }
    else if(payment.isApproved() || payment.isDeclined())
    {
      // Outputs response from BluePay gateway
      System.out.println("Transaction Status: " + payment.getStatus());
      System.out.println("Transaction ID: " + payment.getTransID());
      System.out.println("Transaction Message: " + payment.getMessage());
      System.out.println("AVS Result: " + payment.getAVS());
      System.out.println("CVV2: " + payment.getCVV2());
      System.out.println("Masked Payment Account: " + payment.getMaskedPaymentAccount());
      System.out.println("Card Type: " + payment.getCardType());     
      System.out.println("Authorization Code: " + payment.getAuthCode());
    }
    else 
    {
      System.out.println("ERROR!");
    }
  }
}