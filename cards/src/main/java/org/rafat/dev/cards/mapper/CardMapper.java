package org.rafat.dev.cards.mapper;

import org.rafat.dev.cards.dto.CardDto;
import org.rafat.dev.cards.model.Card;

public class CardMapper {

    public static CardDto mapToCardsDto(Card card, CardDto cardsDto) {
        cardsDto.setCardNumber(card.getCardNumber());
        cardsDto.setCardType(card.getCardType());
        cardsDto.setMobileNumber(card.getMobileNumber());
        cardsDto.setTotalLimit(card.getTotalLimit());
        cardsDto.setAvailableAmount(card.getAvailableAmount());
        cardsDto.setAmountUsed(card.getAmountUsed());

        return cardsDto;
    }

    public static Card mapToCards(CardDto cardsDto, Card card) {
        card.setCardNumber(cardsDto.getCardNumber());
        card.setCardType(cardsDto.getCardType());
        card.setMobileNumber(cardsDto.getMobileNumber());
        card.setTotalLimit(cardsDto.getTotalLimit());
        card.setAvailableAmount(cardsDto.getAvailableAmount());
        card.setAmountUsed(cardsDto.getAmountUsed());

        return card;
    }

}