from datetime import datetime

from flask import Flask, render_template, jsonify, request
from pymongo import MongoClient

app = Flask(__name__)

client = MongoClient("mongodb://localhost:27017/")
db = client.dbStock


@app.route('/')
def index():
    return render_template('index.html')


@app.route('/post', methods=['POST'])
def save_post():
    title_receive = request.form['title_give']
    content_receive = request.form['content_give']

    today = datetime.now()
    date = today.strftime('%Y.%m.%d %H:%M:%S')

    idx = 1

    doc = {
        'idx': db.memo.count() + 1,
        'title': title_receive,
        'content': content_receive,
        'reg_date': today
    }

    db.memo.insert_one(doc)

    return {"result": "success"}


@app.route('/post', methods=['GET'])
def get_post():
    all_memos = list(db.memo.find({}, {'_id': False}))
    print(all_memos)
    return jsonify({'all_memos': all_memos})


@app.route('/post', methods=['DELETE'])
def delete_post():
    idx = request.form['idx']
    db.memo.delete_one({'idx': int(idx)})

    return {"result": "success"}


@app.route('/post', methods=['POST'])
def edit_post():
    title_receive = request.form['title_give']
    content_receive = request.form['content_give']

    today = datetime.now()
    date = today.strftime('%Y.%m.%d %H:%M:%S')

    idx = 1

    doc = {
        'idx': db.memo.count() + 1,
        'title': title_receive,
        'content': content_receive,
        'reg_date': today
    }

    db.memo.update_one(doc)

    return {"result": "success"}


if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000)