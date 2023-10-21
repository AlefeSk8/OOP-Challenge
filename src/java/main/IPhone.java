package java.main;

import java.util.Random;

public class IPhone implements Phone, MusicPlayer, Browser {
   private boolean isRinging;
   private boolean voiceMailEnabled;
   private boolean onCall;

   public IPhone() {
      this.isRinging = false;
      this.voiceMailEnabled = false;
      this.onCall = false;
   }

   public void call(int phoneNumber) {
      this.isRinging = true;
      if (isRinging) {
         System.out.println("Ligando para... " + phoneNumber);
         
         this.onCall = callAccept(phoneNumber);
   
         if (onCall) {
            this.isRinging = false;
            System.out.println("Chamada atendida e em andamento...");
         } else {
            System.out.println("Chamada não atendida.");
            this.voiceMailEnabled = true;
            System.out.println("Iniciando correio de voz...");
            startVoiceMail();
         }
      } else {
         System.out.println("O telefone não está tocando.");
      }

   }
   
   public boolean callAccept(int phoneNumber) {
      this.isRinging = true;
      System.out.println("O número " + phoneNumber + " está te ligando.");

      boolean option = new Random().nextBoolean();

      if (option) {
         this.isRinging = false;
         System.out.println("Ligação de " + phoneNumber + " atendido.");
         return this.onCall = option;
      } else {
         this.isRinging = false;
         System.out.println("Ligação de " + phoneNumber + " recusado.");
         return this.onCall = option;
      }
   }
   
   public boolean callAccept(int phoneNumber, boolean option) {
      this.isRinging = true;
      System.out.println("O número " + phoneNumber + " está te ligando.");

      if (option) {
         this.isRinging = false;
         System.out.println("Ligação de " + phoneNumber + " atendido.");
         return this.onCall = option;
      } else {
         this.isRinging = false;
         System.out.println("Ligação de " + phoneNumber + " recusado.");
         return this.onCall = option;
      }
   }

   public void startVoiceMail() {
      if (voiceMailEnabled) {
         System.out.println("O correio de voz já está ativado.");
         return;
      }

      System.out.println("Correio de voz ativado.");
      voiceMailEnabled = true;
   }

   // MusicPlayer
   static int currentTrack = 0;
   
   public void playMusic() {
      System.out.println("Playing music...");
   }

   public void pauseMusic() {
      System.out.println("Pausing music...");
   }

   public void nextMusicTrack() {
      currentTrack++;
      System.out.println("Next track " + currentTrack);
   }
   
   public void previewTrack() {
      currentTrack--;
      System.out.println("Preview track " + currentTrack);
   }
   
   // Browser
   public void showPage() {
      System.out.println("Showing page...");
   }

   public void addNewTab() {
      System.out.println("New tab added...");
   }

   public void refreshPage() {
      System.out.println("refreshing page...");
   }
}
