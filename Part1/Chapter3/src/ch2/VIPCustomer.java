package ch2;

public class VIPCustomer extends Customer{

    double salesRatio;
    private String agentId;

    public VIPCustomer(){
        bonusRatio = 0.05;
        salesRatio = 0.1;
        customerGrade = "VIP";
    }

    public String getAgentId() {
        return agentId;
    }
}
