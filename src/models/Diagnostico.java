package models;

public class Diagnostico{
        private String data;
        private String doenca;
        
        public Diagnostico(String data, String doenca){
            this.data = data;
            this.doenca = doenca;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public String getDoenca() {
            return doenca;
        }

        public void setDoenca(String doenca) {
            this.doenca = doenca;
        }
    }