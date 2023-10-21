

public interface Phone {

   public void call(int phoneNumber);
   
   public boolean callAccept(int phoneNumber);
   
   public boolean callAccept(int phoneNumber, boolean option);

   public void startVoiceMail();
}
