**1. Tổng thể:**
- Giao diện của ứng dụng được xây dựng bằng bộ công cụ **Jetpack Compose** - mọi giao diện sẽ được xây
  dựng bằng hàm kiểu Kotlin và **giao tiếp trực tiếp** với các biến thông qua **sự thay đổi các trạng thái**.
- Không cần sử dụng XML hay LayoutEditor để xây dựng giao diện.
- Các hàm giao diện này được gắn nhãn @Composable, chúng được định nghĩa và gọi ngay bên trong MainActivity.kt.
  Khi chạy, chúng được **gọi bất kì chứ không tuần tự**. Mỗi khi người dùng **tạo ra 1 sự kiện** nào đó, nó sẽ ảnh hưởng
  đến **trạng thái**, từ đó một số **hàm giao diện được gọi lại** để thay đổi.

**2. Cấu trúc chương trình:**
- hàm _Calculator_: định nghĩa giao diện chính và các biến **number1, number2, result**
- hàm _InputNumber_: chứa TextField(hoạt động giống EditText), định nghĩa giao diện của TextField và nhận các giá trị nhập từ bàn phím,
  đưa vào các biến được truyền tham chiếu khi gọi hàm InputNumber.
- hàm _Button_: một hàm được gọi để định nghĩa giao diện nút, khi nhấp vào nút đó, nó sẽ thực thi khối lệnh bên trong
  onClick = {}.Cụ thể ở đây nó sẽ tính tổng hai số, ẩn bàn phím nhập liệu và hiển thị kết quả.
- Hàm _Spacer_, _Row_, _Column_, _Box_: phục vụ việc xây dựng giao diện,..

**3. Cách hoạt động**
- Ứng dụng sẽ gọi hàm _Calculator_ để lập tức vẽ các giao diện được định nghĩa, bên trong sinh ra các biến chính là **number1, number2,
  result** (các biến còn lại phục vụ giao diện). Gọi 2 lần _InputNumber_, mỗi lần truyền 1 biến **number1, number2,** các đối số còn lại là
  "tên số hạng" và một hàm callback tên OnValueChange, hàm này được gọi lại mỗi khi ta thay đổi giá trị nhập.
- **Number1, number2** được khởi tạo coi như 1 chuỗi String, do TextField chỉ cho phép trả về giá trị vào 1 String nào đó. Còn Result được
  khởi tạo như 1 Float. Sau này, khi tính toán, **number1** và **number2** sẽ được chuyển lại về kiểu Float.
- Các hàm _InputNumber_ sẽ lấy giá trị nhập vào và đưa vào "value", đưa "value" đó cho biến số (**number1 hoặc number2**) được truyền vào.
- Sau đó, khi ta ấn Button, nó sẽ thực thi khối lệnh onClick = {} và tính ra kết quả, đưa vào **result**. Lúc này, ta coi như đã tạo ra
  1 sự kiện, nên giao diện sẽ được vẽ lại, hiển thị kết quả thông qua 1 hàm được Compose định nghĩa sẵn tên Text.


