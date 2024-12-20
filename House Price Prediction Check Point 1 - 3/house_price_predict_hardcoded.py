import joblib

# Muat model dari file
rf = joblib.load('house_price_ranfor_model.pkl')

# Memprediksi Luas Bangunan = 150, Luas Tanah : 200, Kamar Tidur = 3, Kamar Mandi = 2, Garasi = 1 
# [LB, LT, KT, KM, GRS]
prediksi = rf.predict([[150, 200, 3, 2, 1]])[0]

# Menampilkan hasil prediksi dengan pemisah ribuan (,) dan menghilangkan angka desimal (.0f)
print(f"House price prediction: Rp {prediksi:,.0f}")