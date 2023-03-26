import { Routes, Route, useNavigate } from 'react-router-dom';
import { useState, useEffect } from 'react';

import { AuthProvider } from './contexts/AuthContext';
import { schoolServiceFactory } from './services/schoolService';

import { Header } from "./components/Header/Header";
import { Home } from "./components/Home/Home";
import { Login } from './components/Login/Login';
import { Register } from './components/Register/Register';
import { Logout } from './components/Logout/Logout';
import { SchoolList } from './components/SchoolList/SchoolList';
import { SchoolDetails } from './components/SchoolDetails/SchoolDetails';

function App() {
	const navigate = useNavigate();
	const [schools, setSchools] = useState([]);
    const schoolService = schoolServiceFactory();

	useEffect(() => {
        schoolService.getAll()
            .then(result => {
                setSchools(result)
            })
    }, []);


  return (
    <AuthProvider>
		<Header />
			<Routes>
				<Route path="/" element={<Home />} />
				<Route path='/login' element={<Login />} />
				<Route path='/logout' element={<Logout />} />
				<Route path='/register' element={<Register />} />
				<Route path='/schools/all' element={<SchoolList schools={schools}/>} />
				<Route path='/schools/:schoolId' element={<SchoolDetails />} />


			</Routes>
    </AuthProvider>
  );
}

export default App;
