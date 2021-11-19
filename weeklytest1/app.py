from flask import Flask, render_template, jsonify, request
from pymongo import MongoClient
import requests
from bs4 import BeautifulSoup

app = Flask(__name__)

client = MongoClient("mongodb://localhost:27017/")
db = client.dbStock

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/base/codes', methods=['GET'])
def get_base_codes():
    codes = list(db.codes.find({}).distinct("group"))
    return jsonify(codes)

@app.route('/codes', methods=['GET'])
def get_codes():
    group = request.args.get('group')
    codes = list(db.codes.find({'group': group}, {'_id': False}))
    return jsonify(codes)

@app.route('/stocks', methods=['POST'])
def save_info():
    info = request.json
    stocks = list(db.stocks.find(info, {'_id': False}))
    db.searchs.insert_one(info)
    return jsonify(stocks)

@app.route('/stock/like', methods=['PUT'])
def set_like():
    info = request.json
    db.stocks.update_one({"code": info['code']}, {"$set": {"isLike": True}})
    return "success"



