package guru.springframework.sfgdi.openclosed;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClaimApprovalManagerTest {

    @Test
    void processClaim() {
      HealthInsuranceSurveyor healthInsuranceSurveyor = new HealthInsuranceSurveyor();
 
      ClaimApprovalManager claim1 = new ClaimApprovalManager();
 
      claim1.processClaim(healthInsuranceSurveyor);
 
      VehicleInsuranceSurveyor vehicleInsuranceSurveyor = new VehicleInsuranceSurveyor();
 
      ClaimApprovalManager claim2 = new ClaimApprovalManager();
 
      claim2.processClaim(vehicleInsuranceSurveyor);
    }
    }
}
