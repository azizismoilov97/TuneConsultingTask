package admiral.group.tuneconsultingtask.di


import admiral.group.tuneconsultingtask.database.ProjectDAO
import admiral.group.tuneconsultingtask.database.ProjectDatabase
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataModule {

    @Singleton
    @Provides
    fun provideBlogDb(@ApplicationContext context: Context): ProjectDatabase {
        return Room.databaseBuilder(
            context,ProjectDatabase::class.java,
            ProjectDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideBlogDAO(blogDatabase: ProjectDatabase): ProjectDAO {
        return blogDatabase.projectDAO()
    }
}