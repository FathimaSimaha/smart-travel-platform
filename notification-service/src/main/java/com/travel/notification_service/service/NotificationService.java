package com.travel.notification_service.service;

import com.travel.notification_service.entity.Notification;
import com.travel.notification_service.entity.NotificationStatus;
import com.travel.notification_service.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    public Notification sendNotification(Long userId, String message) {
        Notification notification = new Notification(userId, message);
        notification.setStatus(NotificationStatus.SENT);
        System.out.println("Notification sent to user " + userId + ": " + message);
        return notificationRepository.save(notification);
    }

    public Optional<Notification> getNotificationById(Long id) {
        return notificationRepository.findById(id);
    }
}