/** File KoinModule.kt
 *   @Author pierre.antoine - 05/02/2020 - No copyright.
 **/

package com.uldskull.poc_prepoulatedatabase

import org.koin.dsl.module

val appModule = module {




    single { MyDatabase.getDatabase(get()).pocDao() }


}
