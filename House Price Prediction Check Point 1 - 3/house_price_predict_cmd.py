import sys
import joblib
import pandas as pd

# Memeriksa jumlah argumen
if len(sys.argv) != 6:
    print("Usage: python house_price_prediction_cmd.py <LB> <LT> <KT> <KM> <GRS>")
    sys.exit(1)

# Ambil argumen dari command line
LB = int(sys.argv[1])  # Luas Bangunan
LT = int(sys.argv[2])  # Luas Tanah
KT = int(sys.argv[3])  # Kamar Tidur
KM = int(sys.argv[4])  # Kamar Mandi
GRS = int(sys.argv[5]) # Garasi

# Muat model dari file
rf = joblib.load('house_price_ranfor_model.pkl')

data_input = pd.DataFrame([[LB, LT, KT, KM, GRS]], columns=['LB', 'LT', 'KT', 'KM', 'GRS'])

# Prediksi harga rumah
prediksi = rf.predict(data_input)

# Menampilkan hasil prediksi dengan pemisah ribuan (,) dan menghilangkan angka desimal (.0f)
print(f"{prediksi[0]:,.0f}")

# python house_price_predict_cmd.py 150 200 3 2 1