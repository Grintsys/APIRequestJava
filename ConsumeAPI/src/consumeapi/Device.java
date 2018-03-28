/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consumeapi;

/**
 *
 * @author sergioperalta
 */
public class Device {

        private int DeviceId;
        private String Name;
        private int Status;
        private String UpdateDate;

        public Device(){
            
        }
        
        public Device(int DeviceId, String Name, int Status, String UpdateDate) {
            this.DeviceId = DeviceId;
            this.Name = Name;
            this.Status = Status;
            this.UpdateDate = UpdateDate;
        }

        public int getDeviceId() {
            return DeviceId;
        }

        public void setDeviceId(int DeviceId) {
            this.DeviceId = DeviceId;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public int getStatus() {
            return Status;
        }

        public void setStatus(int Status) {
            this.Status = Status;
        }

        public String getUpdateDate() {
            return UpdateDate;
        }

        public void setUpdateDate(String UpdateDate) {
            this.UpdateDate = UpdateDate;
        } 
}
