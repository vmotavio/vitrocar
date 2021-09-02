import { Admin, Resource, fetchUtils} from 'react-admin'
import PostList from './components/PostList'
import PostCreate from './components/PostCreate'
import PostEdit from './components/PostEdit'
import UserList from './components/UserList'
import UserCreate from './components/UserCreate'
import UserEdit from './components/UserEdit'
import authProvider from './authProvider';
import simpleRestProvider from 'ra-data-simple-rest';
import inMemoryJWT from './inMemoryJwt';
import PostCards from './components/PostCards'

const httpClient = (url, options = {}) => {
  if (!options.headers) {
      options.headers = new Headers({ Accept: 'application/json' });
  }
  const token = inMemoryJWT.getToken()
  options.headers.set('Authorization', `Bearer ${token}`);
  return fetchUtils.fetchJson(url, options);
}


const dataProvider = simpleRestProvider('http://localhost:8080/api/v1', httpClient);
console.log(httpClient);
function App() {
  return <Admin dataProvider={dataProvider} authProvider={authProvider}>
     <Resource name="user" list={UserList} create={UserCreate} edit={UserEdit} options={{ label: 'Usuários' }}/>
     <Resource name="car" list={PostList} create={PostCreate} edit={PostEdit}options={{ label: 'Carros' }}/>
     <Resource name="allcars" list={PostCards} options={{ label: 'Vitrine' }}/>
    </Admin>
}

export default App;
