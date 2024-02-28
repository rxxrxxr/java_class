package org.example.components;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService implements InitializingBean, DisposableBean {

    //new 쓰는것보다 메모리 낭비를 줄일수 있다
    @Autowired
    private MemberRepository memberRepository;

    private String str;

    @Override
    public void afterPropertiesSet() throws Exception {
        str = "Jdbc:mysql://192...";
        System.out.println("IOC컨테이너 들어갈때...");
    }
    @Override
    public void destroy() throws Exception {

        System.out.println("IOC컨테이너 없어질때...");
    }

    public void regist() {
        memberRepository.insert();
    }
}
