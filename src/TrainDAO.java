import java.sql.*;

public class TrainDAO {
    static private String DRIVER_NAME = "oracle.jdbc.OracleDriver";
    static private String DB_URL = "jdbc:oracle:thin:@localhost";
    static private String USERNAME = "hr";
    static private String PASSWORD = "hr";

    Class db;
    Connection con;
    Statement stmt;
    PreparedStatement pstmt;
    ResultSet rs;


    public TrainDAO() throws ClassNotFoundException, SQLException {
        db = Class.forName(DRIVER_NAME);
        con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        stmt = null;
        pstmt = null;
        rs = null;
    }

    public static Train findTrain (int trainNo) throws SQLException, ClassNotFoundException {
        TrainDAO db = new TrainDAO();

        db.pstmt = db.con.prepareStatement("SELECT * FROM TRAINS WHERE TRAIN_NO = ?");
        db.pstmt.setInt(1, trainNo);
        db.rs  = db.pstmt.executeQuery();

        while(db.rs.next()){
            if(db.rs.getInt(1) == trainNo){
                return new Train(
                        db.rs.getInt(1),
                        db.rs.getString(2),
                        db.rs.getString(3),
                        db.rs.getString (4),
                        db.rs.getInt(5)
                );
            }
        }
        return null;
    }
}
