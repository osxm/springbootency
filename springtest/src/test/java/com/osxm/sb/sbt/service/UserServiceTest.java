package com.osxm.sb.sbt.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.osxm.sb.sbt.dao.UserRepository;
import com.osxm.sb.sbt.model.User;

@ExtendWith(MockitoExtension.class)  
public class UserServiceTest {  
  
    @Mock  
    private UserRepository userRepository;  
  
    @InjectMocks  
    private UserService userService;  
  
    @Test  
    public void testFindUserById() {  
        // 创建一个模拟的User对象  
        User mockUser = new User();  
        mockUser.setId(1L);  
        mockUser.setName("John Doe");  
  
        // 配置Mockito，当调用userRepository.findById(1L)时，返回mockUser  
        when(userRepository.findById(1L)).thenReturn(Optional.of(mockUser));  
  
        // 调用被测方法  
        User result = userService.findUserById(1L);  
  
        // 验证结果  
        assertNotNull(result);  
        assertEquals(1L, result.getId());  
        assertEquals("John Doe", result.getName());  
  
        // 验证userRepository.findById(1L)确实被调用了一次  
        verify(userRepository, times(1)).findById(1L);  
    }  
  
    // 其他测试用例...  
}
