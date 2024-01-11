package hello.login;

import hello.login.domain.item.Item;
import hello.login.domain.item.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class TestDataInit {

    private final ItemRepository itemRepository;

    /**
     * 테스트용 데이터 추가
     */
    @PostConstruct
    public void init() {
        itemRepository.save(new Item("WOODZ", 10000, 10));
        itemRepository.save(new Item("MOODZ", 20000, 20));
    }

}