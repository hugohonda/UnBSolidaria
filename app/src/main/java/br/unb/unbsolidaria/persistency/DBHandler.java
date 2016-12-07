package br.unb.unbsolidaria.persistency;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import br.unb.unbsolidaria.entities.Opportunity;
import br.unb.unbsolidaria.entities.Organization;
import br.unb.unbsolidaria.entities.User;
import br.unb.unbsolidaria.entities.Voluntary;

/**
 * Created by criss on 06/12/2016.
 */

public class DBHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "userInfo";
    private static final int DATABASE_VERSION = 7;

    private static final String KEY_ID ="id";

    private static final String TABLE_OPPORTUNITY ="opportunity";
    private static final String KEY_ADRESS="adress";
    private static final String KEY_SPOTS="spots";
    private static final String KEY_TITLE="title";
    private static final String KEY_DESCRIPTION="desc";
    private static final String KEY_STARTDATE="sdate";
    private static final String KEY_ENDDATE="edate";
    private static final String KEY_CEP="cep";

    private static final String TABLE_ORGANIZATION ="organization";
    private static final String KEY_CNPJ="cnpj";
    private static final String KEY_LEGALNAME="legalname";
    private static final String KEY_COMMERCIALNAME ="comname";
    private static final String KEY_EMAIL="email";
    private static final String KEY_PHONENUMBER="phoenumber";
    private static final String KEY_WEBSITE="website";

    private static final String TABLE_VOLUNTARY ="voluntary";
    private static final String KEY_CPF="cpf";
    private static final String KEY_NAME="name";
    private static final String KEY_UNBNNUMBER="unbnumber";
    private static final String KEY_GENDER="gender";

    private static final String TABLE_USER="user";
    private static final String KEY_LOGIN="login";
    private static final String KEY_PASSWORD="pass";
    private static final String KEY_TYPE="type";
    private static final String KEY_PROFILE="profile";

    private static DBHandler instance;

    private DBHandler (Context ctx){
        super(ctx, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static synchronized DBHandler getInstance (Context ctx){
        if (instance == null){
            instance = new DBHandler(ctx.getApplicationContext());
        }

        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_OPPORTUNITY_TABLE = "CREATE TABLE " + TABLE_OPPORTUNITY + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_ADRESS + " TEXT, "
                + KEY_SPOTS + " TEXT, " + KEY_TITLE + " TEXT, "
                + KEY_DESCRIPTION + " TEXT, " + KEY_STARTDATE + " TEXT, "
                + KEY_ENDDATE + " TEXT, " + KEY_PROFILE + " INTEGER" + ")";

        String CREATE_VOLUNTARY_TABLE = "CREATE TABLE " + TABLE_VOLUNTARY + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_CPF + " TEXT,"
                + KEY_NAME + " TEXT," + KEY_EMAIL + " TEXT,"
                + KEY_UNBNNUMBER + " TEXT," + KEY_ADRESS + " TEXT," + KEY_GENDER + " TEXT" + ")";


        String CREATE_ORGANIZATION_TABLE = "CREATE TABLE " + TABLE_ORGANIZATION + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_CNPJ + " TEXT,"
                + KEY_LEGALNAME + " TEXT," + KEY_COMMERCIALNAME + " TEXT,"
                + KEY_EMAIL + " TEXT," + KEY_PHONENUMBER + " TEXT,"
                + KEY_WEBSITE + " TEXT," + KEY_DESCRIPTION + " TEXT,"
                + KEY_ADRESS + " TEXT," + KEY_CEP + " TEXT" + ")";

        String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_LOGIN + " TEXT,"
                + KEY_PASSWORD + " TEXT," + KEY_TYPE + " INTEGER," + KEY_PROFILE + " INTEGER" + ")";

        db.execSQL(CREATE_OPPORTUNITY_TABLE);
        db.execSQL(CREATE_VOLUNTARY_TABLE);
        db.execSQL(CREATE_ORGANIZATION_TABLE);
        db.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_OPPORTUNITY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_VOLUNTARY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ORGANIZATION);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        // Creating tables again
        onCreate(db);
    }

    public void addOpportunity(Opportunity item){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");

        values.put(KEY_ADRESS, item.getLocal());
        values.put(KEY_SPOTS, item.getSpots());
        values.put(KEY_TITLE, item.getTitle());
        values.put(KEY_DESCRIPTION, item.getDescription());
        values.put(KEY_STARTDATE, date_format.format(item.getStartDate().getTime()));
        values.put(KEY_ENDDATE, date_format.format(item.getEndDate().getTime()));
        values.put(KEY_PROFILE, item.getOrganization().getId());

        db.insert(TABLE_OPPORTUNITY, null, values);
        db.close();
    }

    public Opportunity getOpportunity(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_OPPORTUNITY, new String[] { KEY_ID,
                        KEY_ADRESS, KEY_SPOTS, KEY_TITLE,
                        KEY_DESCRIPTION, KEY_STARTDATE,
                        KEY_ENDDATE, TABLE_ORGANIZATION}, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null);

        if (cursor == null)
            return null;

        cursor.moveToFirst();
        Opportunity item = new Opportunity(id, cursor.getString(1), cursor.getInt(2), cursor.getString(3),
                cursor.getString(4), Database.getCalendar(cursor.getString(5)), Database.getCalendar(cursor.getString(6)),
                getOrganization(cursor.getInt(7)));

        return item;
    }

    public void delOpportunity(Opportunity item){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_OPPORTUNITY, KEY_ID + " = ?",
        new String[] { String.valueOf(item.getID()) });
        db.close();
    }

    public int getOpportunityCount() {
        String countQuery = "SELECT * FROM " + TABLE_OPPORTUNITY;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();

        return count;
    }

    public List<Opportunity> getAllOpportunities(){
        List<Opportunity> oppList = new LinkedList<>();

        String selectQuery = "SELECT * FROM " + TABLE_OPPORTUNITY + " order by "+ KEY_ID;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Opportunity item = new Opportunity(Integer.parseInt(cursor.getString(0)), cursor.getString(1),
                        cursor.getInt(2), cursor.getString(3),
                        cursor.getString(4), Database.getCalendar(cursor.getString(5)),
                        Database.getCalendar(cursor.getString(6)), getOrganization(cursor.getInt(7)));
                oppList.add(item);
            } while (cursor.moveToNext());
        }

        cursor.close();
        return oppList;
    }

    public void addOrganization (Organization item){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_CNPJ, item.getCnpj());
        values.put(KEY_LEGALNAME, item.getLegalName());
        values.put(KEY_COMMERCIALNAME, item.getCommercialName());
        values.put(KEY_EMAIL, item.getEmail());
        values.put(KEY_PHONENUMBER, item.getPhoneNumber());
        values.put(KEY_WEBSITE, item.getWebsite());
        values.put(KEY_DESCRIPTION, item.getDescription());
        values.put(KEY_ADRESS, item.getAddress());
        values.put(KEY_CEP, item.getCep());

        db.insert(TABLE_ORGANIZATION, null, values);
    }

    public Voluntary getVoluntary(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_ORGANIZATION, new String[] { KEY_ID,
                        KEY_CPF, KEY_NAME, KEY_EMAIL,
                        KEY_UNBNNUMBER, KEY_ADRESS, KEY_GENDER}, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null);

        if (cursor == null)
            return null;

        cursor.moveToFirst();
        Voluntary item = new Voluntary(id, cursor.getString(1), cursor.getString(2), "", Calendar.getInstance(),
                cursor.getString(3), "", "", cursor.getString(4), cursor.getString(5), cursor.getString(6), true);

        return item;
    }

    public void delVoluntary(Voluntary item){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_VOLUNTARY, KEY_ID + " = ?",
                new String[] { String.valueOf(item.getId()) });
        db.close();
    }

    public int getVoluntaryCount() {
        String countQuery = "SELECT * FROM " + TABLE_VOLUNTARY;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();

        return count;
    }

    public List<Voluntary> getAllVoluntaries(){
        List<Voluntary> volList = new LinkedList<>();

        String selectQuery = "SELECT * FROM " + TABLE_VOLUNTARY;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Voluntary item = new Voluntary(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), "", Calendar.getInstance(),
                        cursor.getString(3), "", "", cursor.getString(4), cursor.getString(5), cursor.getString(6), true);
                volList.add(item);
            } while (cursor.moveToNext());
        }

        cursor.close();
        return volList;
    }

    public void addUser(User item){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_LOGIN, item.getLogin());
        values.put(KEY_PASSWORD, item.getPassword());
        values.put(KEY_TYPE, item.getTypeInt());
        values.put(KEY_PROFILE, item.getId());

        db.insert(TABLE_USER, null, values);
        db.close();
    }

    public User getUser(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USER, new String[] { KEY_ID,
                        KEY_LOGIN, KEY_PASSWORD, KEY_TYPE, KEY_PROFILE}, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();
        User item = new User(cursor.getString(1), cursor.getString(2),
                User.getIntType(cursor.getInt(3)), cursor.getInt(4));

        return item;
    }

    public int getUserCount() {
        String countQuery = "SELECT * FROM " + TABLE_USER;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();

        return count;
    }

    public LinkedList<User> getAllUsers(){
        LinkedList<User> usrList = new LinkedList<>();

        String selectQuery = "SELECT * FROM " + TABLE_USER;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                User item = new User(cursor.getString(1), cursor.getString(2),
                        User.getIntType(cursor.getInt(3)), cursor.getInt(4));

                usrList.add(item);
            } while (cursor.moveToNext());
        }

        cursor.close();
        return usrList;
    }

    public User getUserFromCredentials(String email, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USER, new String[] { KEY_ID,
                        KEY_LOGIN, KEY_PASSWORD, KEY_TYPE, KEY_PROFILE}, KEY_LOGIN + " = ?",
                new String[] { email }, null, null, null);

        if (cursor.getCount() == 0)
            return null;

        cursor.moveToFirst();
        System.out.println("password: " + cursor.getString(2));

        if (! password.equals(cursor.getString(2)))
            return null;

        User item = new User(cursor.getString(1), cursor.getString(2),
                User.getIntType(cursor.getInt(3)), cursor.getInt(4));

        return item;
    }

    public void addVoluntary (Voluntary item){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();


        values.put(KEY_CPF, item.getCpf());
        values.put(KEY_NAME, item.getName());
        values.put(KEY_EMAIL, item.getEmail());
        values.put(KEY_UNBNNUMBER, item.getUnbRegistrationNumber());
        values.put(KEY_ADRESS, item.getAddress());
        values.put(KEY_GENDER, item.getGender());

        db.insert(TABLE_VOLUNTARY, null, values);
    }

    public Organization getOrganization(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_ORGANIZATION, new String[] { KEY_ID,
                        KEY_CNPJ,  KEY_LEGALNAME,  KEY_COMMERCIALNAME,
                        KEY_EMAIL, KEY_PHONENUMBER, KEY_WEBSITE,
                        KEY_DESCRIPTION,  KEY_ADRESS, KEY_CEP,}, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();
        Organization item = new Organization(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2),cursor.getString(3),
                cursor.getString(4), cursor.getString(5), cursor.getString(6),
                cursor.getString(7), cursor.getString(8), cursor.getString(9));

        return item;
    }

    public void delOrganization(Organization item){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ORGANIZATION, KEY_ID + " = ?",
                new String[] { String.valueOf(item.getId()) });
        db.close();
    }

    public int getOrganizationCount() {
        String countQuery = "SELECT * FROM " + TABLE_ORGANIZATION;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();

        return count;
    }

    public List<Organization> getAllOrganizations(){
        List<Organization> orgList = new LinkedList<>();

        String selectQuery = "SELECT * FROM " + TABLE_ORGANIZATION;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Organization item = new Organization(Integer.parseInt(cursor.getString(0)),
                        cursor.getString(1), cursor.getString(2),cursor.getString(3),
                        cursor.getString(4), cursor.getString(5), cursor.getString(6),
                        cursor.getString(7), cursor.getString(8), cursor.getString(9));
                orgList.add(item);
            } while (cursor.moveToNext());
        }

        cursor.close();
        return orgList;
    }
}
