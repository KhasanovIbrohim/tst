package com.example.tst.repository;

import com.example.tst.entity.GroupMembers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface GroupMembersRepository extends JpaRepository<GroupMembers, Integer> {
    @Query(value = "select * from group_members gm join users_in_group ug on gm.id = ug.group_members_id and user_id = ?1 join " +
            "groups_with_user g on g.group_members_id = ug.group_members_id where group_id = ?2",nativeQuery = true)
    Optional<GroupMembers> isInGroupUser(UUID userId,UUID groupId);
}
