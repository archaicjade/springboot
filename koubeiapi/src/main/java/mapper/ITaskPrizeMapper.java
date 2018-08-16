//package mapper;
//
//import com.bitauto.i.usertask.model.TaskPrize;
//import com.bitauto.i.usertask.model.TaskPrizeCategory;
//import org.apache.ibatis.annotations.Insert;
//import org.apache.ibatis.annotations.Options;
//import org.apache.ibatis.annotations.Param;
//import org.apache.ibatis.annotations.Select;
//import org.apache.ibatis.mapping.StatementType;
//import org.springframework.cache.annotation.Cacheable;
//
//import java.time.LocalDate;
//import java.util.Collection;
//import java.util.Date;
//
//
//public interface ITaskPrizeMapper {
//    String INSERT_TASKPRIZE = "EXEC Task_Prize_Insert_Prize " +
//            " #{prize.userId}," +
//            " #{prize.taskId}," +
//            " #{prize.clientId}," +
//            " #{prize.taskScheduleId}," +
//            " #{prize.prizeCount}," +
//            " #{prize.prizeExtInfo}";
//
//    @Insert(INSERT_TASKPRIZE)
//    @Options(statementType = StatementType.CALLABLE)
//    void addTaskPrize(@Param("prize") TaskPrize prize);
//
//
//    @Select({
//            "SELECT SUM(PrizeCount)",
//            "FROM   [BitautoUserTask].[dbo].[TaskPrize] WITH(NOLOCK)",
//            "WHERE  UserId=#{userId} AND PublishTime>=#{publishDate,jdbcType=DATE}"
//    })
//    Integer getTaskPrizeCount(@Param("userId") Integer userId, @Param("publishDate") LocalDate publishDate);
//
//
//    @Insert({
//            "INSERT INTO TaskPrizeInterception (UserId,TaskScheduleId,PrizeCount,CreateTime)",
//            "VALUES (#{userId},#{taskSchId},#{prizeCount},GETDATE())"
//    })
//    void addTaskPrizeInterception(@Param("userId") Integer userId, @Param("taskSchId") Integer taskSchId, @Param("prizeCount") Integer prizeCount);
//
//
//    @Select({
//            "SELECT Id,PrizeName,PrizeStrategy,PrizeUnit ",
//            "FROM TaskPrizeCategory ",
//            "WHERE [Status]=1"
//
//    })
//    @Cacheable(value = "usertask.prizecategory")
//    Collection<TaskPrizeCategory> getTaskPrizeCategory();
//
//
//    @Select({
//            "SELECT Id,PrizeName,PrizeStrategy,PrizeUnit ",
//            "FROM TaskPrizeCategory ",
//            "WHERE [Status]=1 AND Id=#{id}"
//    })
//    @Cacheable(value = "usertask.prizecategorybyid")
//    TaskPrizeCategory getTaskPrizeCategoryById(@Param("id") Integer id);
//
//}
