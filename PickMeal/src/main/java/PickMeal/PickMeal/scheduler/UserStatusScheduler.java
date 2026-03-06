package PickMeal.PickMeal.scheduler; // 🚩 새로운 패키지 경로

import PickMeal.PickMeal.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserStatusScheduler {

    private final UserMapper userMapper;

    // 매일 자정(00시 00분 00초)에 실행
    @Scheduled(cron = "0 0 0 * * *")
    public void autoReleaseSuspendedUsers() {
        System.out.println("🤖 정지 해제 스케줄러 작동 시작!");

        userMapper.releaseExpiredSuspensions();

        System.out.println("🤖 정지 기한이 만료된 회원들의 정지가 해제되었습니다.");
    }
}