Trabalho desenvolvido para a disciplina de DMO no segundo semestre do curso de ADS no Campus Araraquara





## Activities


- `ChatActivity.java`: Atividade principal que mostra a conversa         individual (chatroom).
- `LoginOtpActivity.java`: Cuida da autenticação por OTP.
- `LoginPhoneNumberActivity.java`: Cuida do login usando o número de telefone.
- `LoginUsernameActivity.java`: Controla o login usando o nome de usuário.
- `MainActivity.java`:Tela home onde aparece o recycler view com os chats individuais.
- `SearchUserActivity.java`:Permite usuários pesquisarem outros usuários para começar uma conversa (É case-sensitive).
- `SplashActivity.java`:Splash screen enquanto o app inicia.


## Fragments


- `ChatFragment.java`: Gerencia a UI  e a lógica da activity chat.
- `ProfileFragment.java`: Gerencia o display e a edição dos dados da user profile.
- `SearchUserFragment.java`: Mostra os resultados da busca de usuários e pode ser clicado para levar até o chat com tal usuário.


## Serviços


- `FCMNotificationService.java`: Integração do Firebase Cloud Messaging para as notificações push.






## Usando o app




1. Clone ou baixe o repositório.
2. Configure o projeto no firebase e atualize o arquivo `google-services.json`          .
3. Construa e execute o app no emulador ou aparelho android.


4. Ou você pode baixar o apk em MindsApp.apk



Foram utilizadas como fonte:
1.Documentação Firebase;
2.Documentação para programação android (Google);
3.https://www.youtube.com/watch?v=jHH-ZreOs1k&list=LL&index=26&t=4316s;
4.biblioteca Dhaval2404 ImagePicker.
