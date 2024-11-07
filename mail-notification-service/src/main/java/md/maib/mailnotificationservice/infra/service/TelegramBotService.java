package md.maib.mailnotificationservice.infra.service;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.springframework.stereotype.Component;

@Component
public class TelegramBotService extends TelegramLongPollingBot {

    private final String botToken = "7692223871:AAGiRbephQt7PIflj3PrtRFOFQ6ufsOdpGo";
    private final String botUsername = "YourBotUsername";

    @Override
    public void onUpdateReceived(Update update) {
        // Process incoming messages if needed
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    public void sendMessage(String chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(text);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
