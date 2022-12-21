import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import java.io.*;



public class Bot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {

        return "testermek39bot";
    }

    @Override
    public String getBotToken() {

        return "5892102746:AAG1kxCrT8-y9GyjvUVOwM3ShGnr0tXAshA";
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        String response = message.getFrom().getId().toString();
        System.out.println(message.getText());
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(message.getChatId().toString());
        InputFile newFile = new InputFile();
        newFile.setMedia(new File("image.jpg"));
        sendPhoto.setPhoto(newFile);
        sendPhoto.setCaption("This is Java");

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText("Your message"+response);
        try {
            execute(sendMessage);
            execute(sendPhoto);
        }catch (TelegramApiException e){
            e.printStackTrace();
        }
    }
}

