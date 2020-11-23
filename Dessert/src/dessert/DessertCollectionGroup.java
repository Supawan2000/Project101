package dessert;

public class DessertCollectionGroup {
/* DessertCollectionGroup class เก็บ array ของ Dessert
 */
    private Dessert[] desserts; // array เก็บของหวาน
    private int count; // จำนวนของของหวานที่เก็บอยู่ใน array

    /*
     * constructor สร้าง DessertCollectionGroup
     * ที่สามารถเก็บ Fruit ได้ทั้งหมด size ชนิด
     * size คือ ขนาดของ DessertCollectionGroup ที่ต้องการสร้าง ซึ่งถ้า size
     * น้อยกว่าหรือเท่ากับ 0 จะสร้าง DessertCollectionGroup ที่มีขนาดเท่ากับ 1
     */
    public DessertCollectionGroup(int size) {
        size = (size > 0) ? size : 1;
       desserts = new Dessert[size];
    }
    
    public int getCount() { 
        return count;
    }
    
     /*
     * ตรวจสอบว่า DessertCollectionGroup นี้เต็มแล้วหรือไม่
     * return true ถ้า DessertCollectionGroup นี้เต็มแล้ว; false ถ้า DessertCollectionGroup
        นี้ยังไม่เต็ม
     */
    public boolean isFull() {
        return count == desserts.length;
    }
    
    /*
     * ใส่ผลไม้เข้าไปใน DessertCollectionGroup
     * name ชื่อของของหวานที่ต้องการใส่
     * price ราคาของของหวานที่ต้องการใส่
     * quality คุณภาพของของหวานที่ต้องการใส่
     * return false ถ้าไม่สามารถใส่ของหวานเข้าไปใน DessertCollectionGroup ได้ เนื่องจาก
       DessertCollectionGroup เต็ม หรือ price น้อยกว่า 0 หรือ quality ไม่ได้อยู่ในช่วง
       1 ถึง 10; true ถ้าสามารถใส่ของหวานเข้าไปใน DessertCollectionGroup ได้
     */
    public boolean addDessert(String name, double price, int quality) {
        if (price < 0 || quality < 1 || quality > 10 || isFull()) {
            return false;
        }
        desserts[count++] = new Dessert(name, price, quality);
        return true;
    }
    
    /*
     * ขอ Dessert ใน DessertCollectionGroup ในช่อง slot
     * slot ช่องที่ต้องการขอ Dessert จาก 
     * return null ถ้า slot ที่ขอไม่มีของหวานหรือเกินขอบเขตของ array; Dessert
     * ในช่อง slot ของ DessertCollectionGroup ที่ขอ
     */
    public Dessert getDessertAt(int slot) {
        if (slot >= 0 && slot < count) {
            return desserts[slot];
        }
        return null;
    }
    
    /*
     * ขยายขนาดของ DessertCollectionGroup เพิ่มขึ้นอีก 
       size และ return true แต่ถ้า size น้อยกว่า 1 จะไม่ขยาย 
       และจะ return false
     * size ขนาดที่ต้องการเพิ่มขึ้น
     * return true ถ้าทำสำเร็จ; false ถ้าไม่มีการขยาย
     */
    public boolean expand(int size) {
        if (size <= 0) {
            return false;
        }
        Dessert d[] = new Dessert[desserts.length + size];
        System.arraycopy(desserts, 0, d, 0, count);
        // for (int i = 0; i < count; i++) f[i] = desserts[i];
        desserts = d;
        return true;
    }
    
    /*
     * หาของหวานที่ชื่อ name ใน DessertCollectionGroup และ return
       ตำแหน่งแรกที่พบของหวานตามชื่อนั้น หากไม่พบของหวานในชื่อนั้น หรือ name เป็น
       null ให้ return -1
     
     * name ชื่อของของหวานที่ต้องการหา
     * return ตำแหน่งแรกที่พบ
     */
    public int searchForDessertName(String name) {
        if (name == null) {
            return -1;
        }
        for (int i = 0; i < count; i++) {
            if (name.equals(desserts[i].getName())) {
                return i;
            }
        }
        return -1;
    }
}
