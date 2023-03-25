import { Routes, Route, useNavigate } from 'react-router-dom';

import { AuthProvider } from './contexts/AuthContext';

import { Header } from "./components/Header/Header";
import { Home } from "./components/Home/Home";
import { Login } from './components/Login/Login';
import { Register } from './components/Register/Register';
import { Logout } from './components/Logout/Logout';

function App() {
  return (
    <AuthProvider>
		<Header />
			<Routes>
				<Route path="/" element={<Home />} />
				<Route path='/login' element={<Login />} />
				<Route path='/logout' element={<Logout />} />
				<Route path='/register' element={<Register />} />
			</Routes>
    </AuthProvider>
  );
}

export default App;
