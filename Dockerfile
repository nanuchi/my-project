FROM python:3.10.4
RUN mkdir /app
WORKDIR /app
COPY requirements.txt ./requirements.txt
RUN pip install -r requirements.txt
COPY . /app
EXPOSE 80
RUN mkdir ~/.streamlit
RUN cp config.toml ~/.streamlit/config.toml
WORKDIR /app
CMD streamlit run app.py --server.port 80 --server.enableWebsocketCompression=false
